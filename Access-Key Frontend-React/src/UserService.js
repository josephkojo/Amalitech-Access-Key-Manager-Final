import axios from "axios";

class UserService{

  static BASE_URL = "http://localhost:8080";
  
  static async register(requestBody){
    try{
      
    const response = await axios.post(`${UserService.BASE_URL}/auth/register`, requestBody);
    return response.data;

    }catch(err){
      throw err;
    }
    

  }

}
export default UserService;