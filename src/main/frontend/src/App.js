import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';


function App() {
    const [message, setMessage] = useState('');

    useEffect(() => {
        axios.get('/api/hello')
            .then(response => {
                console.log(response.data); // 콘솔 로그로 응답 데이터 확인
                setMessage(response.data);
            })
            .catch(error => {
                console.error('Error fetching data:', error); // 에러 메시지 출력
            });
    }, []);

    return (
        <div className="App">
            <header className="App-header">
                <p>TEST</p>
                <p>{message}</p>
            </header>
        </div>
    );
}

export default App;
