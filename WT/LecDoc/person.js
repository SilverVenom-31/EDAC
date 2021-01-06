import React from 'react';
import './Person.css'

const person = (props)=>{
    return(
        <div className='Person'>
            <p onClick= {props.click} className='text-primary'>
                Hi, I am {props.name} and I am {props.age} years old
            </p>
    <p>{props.childern}</p>
            <input type="text"  value={props.name}  onChange={props.change} />
        </div>
    )
}
export default person;