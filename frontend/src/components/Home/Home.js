import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function App() {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const result = await axios.get('http://localhost:8080/posts');
        setData(result.data);
      } catch (error) {
        console.log('Error fetching data:', error);
      }
    };
    fetchData();
  }, []);

  return (
    <>
      <div>
        <Link to="/user">User</Link>
      </div>
      <div>
        <Link to="/home">Home</Link>
      </div>
      <ul>
        {data.map((post) => (
          <div className='test' key={post.id}>
            <li>
              Title: {post.title}
            </li>
            <li>
              Text: {post.text}
            </li>
          </div>
        ))}
      </ul>
    </>
  );
}

export default App;
