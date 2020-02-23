import React from 'react';
import 'antd/dist/antd.css';
import { Layout } from 'antd';
import "./signup.css";

import {
    Form,
    Input,
    Select,
    Button,
    AutoComplete, PageHeader,
} from 'antd';
import FormItem from "antd/es/form/FormItem"
import Title from "antd/es/skeleton/Title"


const {Option} = Select;
const AutoCompleteOption = AutoComplete.Option;


class RegistrationForm extends React.Component {
    state = {
        confirmDirty: false,
        autoCompleteResult: [],
    };

    handleSubmit = e => {
        e.preventDefault();
        this.props.form.validateFieldsAndScroll((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
            }
        });
    };

    handleConfirmBlur = e => {
        const {value} = e.target;
        this.setState({confirmDirty: this.state.confirmDirty || !!value});
    };

    compareToFirstPassword = (rule, value, callback) => {
        const {form} = this.props;
        if (value && value !== form.getFieldValue('password')) {
            callback('Two passwords that you enter is inconsistent!');
        } else {
            callback();
        }
    };

    validateToNextPassword = (rule, value, callback) => {
        const {form} = this.props;
        if (value && this.state.confirmDirty) {
            form.validateFields(['confirm'], {force: true});
        }
        callback();
    };

    handleWebsiteChange = value => {
        let autoCompleteResult;
        if (!value) {
            autoCompleteResult = [];
        } else {
            autoCompleteResult = ['.com', '.org', '.net'].map(domain => `${value}${domain}`);
        }
        this.setState({autoCompleteResult});
    };

    render() {
        const {getFieldDecorator} = this.props.form;
        const {autoCompleteResult} = this.state;

        return (
            <div>
                <div className= "title">Travel Planner Sign Up</div>

                <Form onSubmit={this.handleSubmit} className= "signup-form">
                    <Form.Item  className = "email">
                        {getFieldDecorator({
                            rules: [
                                {
                                    type: 'email',
                                    message: 'The input is not valid E-mail!',
                                },
                                {
                                    message: 'Please input your E-mail!',
                                },
                            ],
                        })(<Input placeholder= "Your Email" className={"email-input"}/>)}
                    </Form.Item>
                    <Form.Item className={"password"} hasFeedback>
                        {getFieldDecorator('password', {
                            rules: [
                                {
                                    validator: this.validateToNextPassword,
                                },
                            ],
                        })(<Input.Password placeholder={"Create Password"} className={"password-input"}/>)}
                    </Form.Item>
                    <div className={"container"}>
                    <Form.Item className={"firstname"} >
                        {getFieldDecorator('FirstName', {
                            rules: [
                                {
                                    validator: this.validateToNextPassword,
                                },
                            ],
                        })(<Input placeholder={"First Name"} className={"firstname-input"}/>)}
                    </Form.Item>

                    <Form.Item className={"lastname"}>
                        {getFieldDecorator('LastName', {
                            rules: [
                                {
                                    validator: this.validateToNextPassword,
                                },
                            ],
                        })(<Input placeholder={"Last Name"} className={"lastname-input"}/>)}
                    </Form.Item>
                    </div>

                    <Form.Item >
                        <Button type="primary" htmlType="submit">
                            Register
                        </Button>
                    </Form.Item>
                </Form>
            </div>
        );
    }
}

export const WrappedRegistrationForm = Form.create({name: 'register'})(RegistrationForm);

