import React, { useEffect, useState } from 'react'
import { deleteEmployee, listEmployees } from '../Services/EmployeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {

    const [employess,setEmployee] = useState([])

    const navigatotor = useNavigate();
 
    useEffect(() =>{
     getAllEmployees();
        
    },[])

    function getAllEmployees(){
        listEmployees().then((Response)=>{
            setEmployee(Response.data);
        }).catch(error=>{
            console.error(error);
        })
    }

    function addNewEmployee(){
        navigatotor('/add-employee');
          
    }

    function upDateEmployee(id){
        navigatotor(`/edit-employee/${id}`)
    }

    function removeEmployee(id){
        console.log(id);

        deleteEmployee(id).then((response) =>{
            getAllEmployees();
        }).catch(error=>{
            console.error(error);
        })
    }
   
  return (
    <div className='container'>
        <h1 className='text-center'> List of employess </h1>
        <button className='btn btn-primary mb-2'onClick={addNewEmployee} > Add Employee</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Employee id</th>
                    <th>Employee first name</th>
                    <th>Employee last name</th>
                    <th>Employee email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    employess.map(emplyee =>
                        <tr key={emplyee.id}>
                            <td>{emplyee.id}</td>
                            <td>{emplyee.firstName}</td>
                            <td>{emplyee.lastName}</td>
                            <td>{emplyee.email}</td>
                            <td>
                                <button className='btn btn-info' onClick={()=>upDateEmployee(emplyee.id)}>Update</button>
                                <button className='btn btn-danger' onClick={()=>removeEmployee(emplyee.id)}>Delete</button>
                            </td>
                        </tr>)
                    
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent