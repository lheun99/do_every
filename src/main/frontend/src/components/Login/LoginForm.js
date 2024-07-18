import React, { useState } from 'react';
import { Form, Button, Container } from 'react-bootstrap';
import './LoginForm.css'; // CSS 파일을 import 합니다.
import { login } from './api'; // api.js 파일을 import 합니다.

const LoginForm = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [emailError, setEmailError] = useState('');
  const [loginError, setLoginError] = useState('');

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
    if (!validateEmail(e.target.value)) {
      setEmailError('Please enter a valid email address.');
    } else {
      setEmailError('');
    }
  };

  const validateEmail = (email) => {
    // 간단한 이메일 형식 검사 정규식
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(String(email).toLowerCase());
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (!validateEmail(email)) {
      setEmailError('Please enter a valid email address.');
      return;
    }
    try {
      const data = await login(email, password);
      console.log('Login successful:', data);
      // 로그인 성공 후 처리 로직을 여기에 추가
    } catch (error) {
      setLoginError('Login failed. Please check your credentials and try again.');
      console.error('Login error:', error);
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h2 className="mb-4 text-center">Login</h2>
        {loginError && <div className="alert alert-danger">{loginError}</div>}
        <Form onSubmit={handleSubmit}>
          <Form.Group controlId="formBasicEmail" className="mb-2">
            <Form.Label>Email address</Form.Label>
            <Form.Control
              type="email"
              placeholder="Enter email"
              value={email}
              onChange={handleEmailChange}
              isInvalid={!!emailError}
            />
            <Form.Control.Feedback type="invalid">
              {emailError}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group controlId="formBasicPassword" className="mb-2">
            <Form.Label>Password</Form.Label>
            <Form.Control
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </Form.Group>

          <Button variant="primary" type="submit" className="w-100">
            Login
          </Button>
        </Form>
      </div>
    </div>
  );
};

export default LoginForm;
