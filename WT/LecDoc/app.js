import logo from './logo.svg';
import './App.css';
import Person from "./Person/Person"
import StatefulComponent from './StatefulComponent/StatefulComponent';
import React, { Component } from 'react';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//         <StatefulComponent />
//       </header>
//     </div>
//   );
// }

class App extends Component{
  state = {
    // for changing the name dynamically
    //we can remove this also
    // uname:"",
    persons:[
      {
        name:"Gaurav", age:22
      },
      {
        name:"Rahul", age:29
      },
      {
        name:"Abhishek", age:12
      }
    ]
  }

  // btnHandler = function(){}
  // passing parameter in the button handler function
    btnHandler = (newName) => {
    // btnHandler = () => {
    // alert("Button Clicked")
    // quick and dirty way
    // never manipulate the state directly
    // this.state.persons[0].name = "RahulGoyal"

    // method given by Component class that allows to mutate the state
    this.setState(
      {

        

        persons:[
          {
            name:newName, age:22
            // name:"Gaurav", age:22
          },
          {
            name:"Rahul", age:39
          },
          {
            name:"Abhishek", age:22
          }
        ]
      }
    )
  }
  // e or event both are same 
  // this is two way binding
  // change in text box will be reflected on the webpage
  inputHandler = (event) => {
    this.setState({
      // with uname
      // {uname:event.target.value}
      persons:[
        {
          name:event.target.value, age:22
        },
        {
          name:"Rahul", age:29
        },
        {
          name:"Abhishek", age:12
        }
      ]
    })
  };

  render(){
    // css for button
    // const mystyle= {backgroundColor: 'blue',
    //                 color:'white',
    //                 font:'inherit',
    //                 cursor:'pointer'};

    const nums = [1,2,3,4,5];
    const updatednums = nums.map(num=>{
      return <li>{num*num}</li>
    })

    const items = [{name:"Item-1"}, {name:"Item-2"}, {name:"Item-3"}]
    const updateditems = items.map(item=>{
    return  <p>{item.name}</p>
    })

    const students =[
      {name:'Nikhil', age:25},
      {name:'Rahul', age:35},
      {name:'Rinky', age:19}
    ]
    // in react we can do =>() which will do implicit return instead of =>{} in which we have to return
    const updatedstudents = students.map(student=>(
      <tr>
        <td>{student.name}</td>
        <td>{student.age}</td>
      </tr>
    ))
    

    return(
      <div className="App">
        <h1 className="text-danger" >Hi, welcome to react</h1>

        {/* {nums} */}
        {/* {updatednums} */}
        {/* {updateditems} */}
        <table border="1">
          {updatedstudents}
        </table>
        {/* Name: <input type="text" value={this.state.uname} onChange={this.inputHandler}></input> */}
        {/* <br /> */}
        {/* Hello - {this.state.uname} */}




        {/* <button onClick={this.btnHandler} type="button">Switch Name</button> */}
        {/* code convention says to go with the bind */}
        {/* <button onClick={this.btnHandler.bind(this,"Alpha")} type="button">Switch Name</button> */}
        <br />
        {/* <button onClick={()=> this.btnHandler("Alpha")} type="button">Switch Name</button> */}
        {/* <button style={mystyle} className="btn btn-primary"
                onClick={()=> this.btnHandler("Alpha")} type="button">Switch Name</button> */}
        <button className="btn btn-primary"
         onClick={()=> this.btnHandler("Alpha")} type="button">Switch Name</button>
        <Person
                name={this.state.persons[0].name}
                age={this.state.persons[0].age}
                // name of the property can be anything
                // passing method referneces between components
                // click = {this.btnHandler}>
                change = {this.inputHandler}>
        </Person>
        <Person name={this.state.persons[1].name} age={this.state.persons[1].age}></Person>
        <Person name={this.state.persons[2].name} age={this.state.persons[2].age}></Person>
      </div>
    )
  }
}

export default App;
