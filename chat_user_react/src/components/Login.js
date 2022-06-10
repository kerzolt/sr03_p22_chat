import React, {useState} from "react";
import axios from "axios";
import {Link, useNavigate} from "react-router-dom";

const Login = (props) => {
    const [mail, setMail] = useState('')
    const [password, setPassword] = useState('')

    const nav = useNavigate();

    const handleLogin = () => {
        console.log("mail = " + mail)
        console.log("password = " + password)

        // axios
        axios.post("http://localhost:8080/login/react", {mail: mail, password: password})
            .then(res => {
                console.log(res.data);
                sessionStorage.setItem("userId", res.data.id)
                nav("/channels")
            })
    }

    return (
        <div className="login-container">
            <form onSubmit={handleLogin}>
                <input type="text" name="mail" value={mail}
                       onChange={e => {
                           setMail(e.target.value)
                       }}/>
                <input type="password" name="password" value={password}
                       onChange={e => {
                           setPassword(e.target.value)
                       }}/>
                <input type="button" value="Login" onClick={handleLogin}/>
                <Link to="/chat/42">Chat</Link>
            </form>
        </div>
    );
}

export default Login;
