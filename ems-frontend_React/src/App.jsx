import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

import ListEmployeeComponent from './Components/ListEmployeeComponent'
import HeadderComponent from './Components/HeadderComponent'
import FooterComponent from './Components/FooterComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import EmployeeComponent from './Components/EmployeeComponent'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <BrowserRouter>
            <HeadderComponent/>
            <Routes>
              //http://localhost:3000
              <Route path='/' element = {<ListEmployeeComponent/>}> </Route>
              //http://localhost:3000/employess
              <Route path='/employess' element = {<ListEmployeeComponent/>}></Route>
              //http://localhost:3000/add-employee
              <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
              //http://localhost:3000/edit-employee/1
              <Route path='edit-employee/:id' element={<EmployeeComponent/>}></Route>
            </Routes>
           
            <FooterComponent/>
     </BrowserRouter>
     </>
  )
}

export default App
