import { Button } from 'bootstrap'
//import React from 'react'
import React,{useEffect, useState} from 'react'
import { createEmployee, getEmployee, updateEmployee } from '../Services/EmployeService'
import { useNavigate,useParams } from 'react-router-dom'

const EmployeeComponent = () => {

const [firstName, setfirstName,] = useState('')
const [lastName, setlastName,] = useState('')
const [email, setEmail,] = useState('')
const {id} = useParams();

const[errors, setErrors] = useState({
    firstName:'',
    lastName:'',
    email:''
})
    

const navigatotor = useNavigate();

useEffect(() =>{
    if(id){
        getEmployee(id).then((respose) =>{
            setfirstName(respose.data.firstName);
            setlastName(respose.data.lastName);
            setEmail(respose.data.email);

        }).catch(error =>{
            console.error(error);
        });
        
    }

},[id]);





  

function SaveOrUpdateEmployee(e){
    e.preventDefault();

    if(validateForm()){

        const employee = {firstName,lastName,email}
        console.log(employee)

        if(id){
            updateEmployee(id,employee).then((respose) =>{
                console.log(respose.data);
                navigatotor('/employess');
            }).catch(error => {
                console.error(error);
            })
        }else{

            createEmployee(employee).then((response) =>{
                console.log(response.data);
                navigatotor('/employess');
            }).catch(error =>{
                console.error(error);
                
            })
        }

     }

   

}

function validateForm(){
    let valid = true;

    const errorCopy = {...errors}

    if(firstName.trim()){
        errorCopy.firstName = '';
    }else{
        errorCopy.firstName = 'First name is required';
        valid = false;
    }

    if(lastName.trim()){
        errorCopy.lastName = '';
    }else{
        errorCopy.lastName = 'Last name is required';
        valid = false;
    }

    if(email.trim()){
        errorCopy.email = '';
    }else{
        errorCopy.email= 'email id is required';
        valid = false;
        
    }
    setErrors(errorCopy);
    return valid;
}
function pageTitele(){
    if(id){
      return<h2 className='text-center'> Update Employee</h2>  
    }else{
        return<h2 className='text-center'> Add Employee</h2>
    }

}

  return (
    <div className='container'>
        ,<br /><br></br>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                
                {
                    pageTitele()
                }
                <div className='card-body'>
                    <form>
                        <div className='form-grou mb-2'>
                            <label className='form-label'> First Name</label>
                            <input 
                                type="text"
                                placeholder='Enter Employee first Name'
                                name='firstName'
                                value={firstName} 
                                className={`form-control ${errors.firstName ? 'is-valid':'' }`}
                                onChange={(e) => setfirstName(e.target.value)}
                            >

                            </input>
                            {errors.firstName && <div className='invalid-feedback'> {errors.firstName}</div>}
                        </div>

                        <div className='form-grou mb-2'>
                            <label className='form-label'> Last Name</label>
                            <input 
                                type="text"
                                placeholder='Enter Employee Last Name'
                                name='lastName'
                                value={lastName} 
                                className={`form-control ${errors.lastName ? 'is-valid':'' }`}
                                onChange={(e) =>setlastName(e.target.value)}
                                >
                                
                            
                         </input>
                         {errors.lastName && <div className='invalid-feedback'> {errors.lastName}</div>}
                        </div>

                        <div className='form-grou mb-2'>
                            <label className='form-label'>  emailId</label>
                            <input 
                                type="text"
                                placeholder='Enter Employee Email'
                                name='emailid'
                                value={email} 
                                className={`form-control ${errors.email ? 'is-valid':'' }`}
                                onChange={(e)=> setEmail(e.target.value)}
                            >

                            </input>
                            {errors.email && <div className='invalid-feedback'> {errors.email}</div>}
                        </div>
                        <button className='btn btn-success' onClick={SaveOrUpdateEmployee}>Submit</button>
                    </form>

                </div>

            </div>

        </div>

    </div>
  )
}

export default EmployeeComponent