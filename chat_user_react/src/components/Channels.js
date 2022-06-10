import React, {useEffect, useState} from "react";
import axios from "axios";

const Channels = (props) => {
    const [channels, setChannels] = useState([])

    // => "onload"
    useEffect(() => {
        fetchChannels()
    }, [])

    const fetchChannels = () => {
        // axios
        axios.get("http://localhost:8080/channels?userId=" + sessionStorage.getItem("userId"))
            .then(res => {
                setChannels(res.data);
            })
    }

    return (
        <div>
            {channels && channels.map((channel) => (
                <div key={channel.id}>{channel.title}</div>
            ))}
        </div>
    );
}

export default Channels;
