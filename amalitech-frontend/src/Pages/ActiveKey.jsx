import React, { useState, useEffect } from "react";
import { Card, Container, Button, Form, Row, Col } from 'react-bootstrap'; 
import { ToastContainer, toast } from 'react-toastify'; 
import 'react-toastify/dist/ReactToastify.css';
import UserService from "../UserService";
import './Login.css';

const ActiveKey = () => {
  const [accessKeys, setAccessKeys] = useState(null);
  const [email, setEmail] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  useEffect(() => {
    const storedEmail = localStorage.getItem('email');
    if (storedEmail) {
      setEmail(storedEmail);
    }
  }, []);

  useEffect(() => {
    localStorage.setItem('email', email);
  }, [email]);

  const fetchActiveKey = async (email, token) => {
    try {
      const response = await UserService.adminGetActive(email, token);
      setAccessKeys(response);
      toast.success("Data fetched successfully!");
    } catch (error) {
      toast.error("Sorry the school does not have an active key");
      console.error(error);
    }
  };

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handleClick = async () => {
    if (!email) {
      toast.warn("Please enter an email address");
      return;
    }

    setIsLoading(true);
    try {
      const token = localStorage.getItem('token');
      await fetchActiveKey(email, token);
    } catch (error) {
    
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <Container className="mt-5">
      <Row className="justify-content-center">
        <Col xs={12} md={6} lg={4}>
          <Form>
            <Form.Group className="mb-3">
              <Form.Label><strong>Enter school email address to get details of an active key</strong></Form.Label>
              <Form.Control 
                type="email" 
                value={email} 
                onChange={handleEmailChange} 
                disabled={isLoading}
                className="w-100"
              />
            </Form.Group>
            <Button variant="primary" onClick={handleClick} disabled={isLoading} className="w-100">
              {isLoading ? "Loading..." : "Submit"}
            </Button>
          </Form>
        </Col>
      </Row>
      {accessKeys && (
        <Card style={{ width: '18rem' }} className="mx-auto mt-4">
          <Card.Body>
            <Card.Title>Active Key Details</Card.Title>
            <Card.Subtitle className="mb-2 text-muted">{accessKeys.title || "No title"}</Card.Subtitle>
            <Card.Text>
              {accessKeys.description || "No description available"}
            </Card.Text>
            <Card.Link href="#">{accessKeys.key}</Card.Link>
            <Card.Link href="#">Another link</Card.Link>
          </Card.Body>
        </Card>
      )}
      <ToastContainer />
    </Container>
  );
};

export default ActiveKey;
