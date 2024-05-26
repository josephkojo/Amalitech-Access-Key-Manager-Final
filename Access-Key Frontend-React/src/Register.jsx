import React, { useState } from 'react';
import { Form, Button, Container, Row, Col } from 'react-bootstrap';
import UserService from './UserService';
import { toast } from 'react-toastify';

const Register = () => {
  const [formData, setFormData] = useState({
    firstname: '',
    lastname: '',
    email: '',
    schoolEmail: '',
    password: ''
  });
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false); // Loading state

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');

    if (formData.password.length < 8) {
      setError('Password must be at least 8 characters long.');
      return;
    }

    setLoading(true);
    try {
      const response = await UserService.register(formData);
      localStorage.setItem('token', response.token);
      toast.success("Registration successfull");
      setTimeout(()=>{
        console.log('ok')

      }, 2000)
      
      setLoading(false);
    } catch (err) {
      setError('Email has already been used');
      setLoading(false);
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  return (
    <Container className="py-5">
      <Row className="justify-content-center">
        <Col xs={12} md={8} lg={6}>
          <div className="shadow p-4 rounded">
            <h3 className="text-center mb-4">Create an Account for Your School</h3>
            <Form onSubmit={handleSubmit}>
              <Form.Group className="mb-3" controlId="firstname">
                <Form.Label>First Name</Form.Label>
                <Form.Control
                  type="text"
                  name="firstname"
                  value={formData.firstname}
                  onChange={handleInputChange}
                  placeholder="Enter first name"
                  required
                />
              </Form.Group>

              <Form.Group className="mb-3" controlId="lastname">
                <Form.Label>Last Name</Form.Label>
                <Form.Control
                  type="text"
                  name="lastname"
                  value={formData.lastname}
                  onChange={handleInputChange}
                  placeholder="Enter last name"
                  required
                />
              </Form.Group>

              <Form.Group className="mb-3" controlId="email">
                <Form.Label>Email Address</Form.Label>
                <Form.Control
                  type="email"
                  name="email"
                  value={formData.email}
                  onChange={handleInputChange}
                  placeholder="Enter email"
                  required
                />
              </Form.Group>

              <Form.Group className="mb-3" controlId="schoolEmail">
                <Form.Label>School Email</Form.Label>
                <Form.Control
                  type="email"
                  name="schoolEmail"
                  value={formData.schoolEmail}
                  onChange={handleInputChange}
                  placeholder="Enter school email"
                  required
                />
              </Form.Group>

              <Form.Group className="mb-3" controlId="password">
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  name="password"
                  value={formData.password}
                  onChange={handleInputChange}
                  placeholder="Password"
                  required
                />
                <Form.Text className="text-muted">Password must be at least 8 characters long.</Form.Text>
              </Form.Group>

              {error && <div className="alert alert-danger">{error}</div>}

              <div className="d-grid">
                <Button variant="primary" type="submit" size="lg" disabled={loading}>
                  {loading ? 'Registering...' : 'Register'}
                </Button>
              </div>
            </Form>
          </div>
        </Col>
      </Row>
    </Container>
  );
};

export default Register;
