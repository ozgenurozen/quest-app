import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './index.css';

import Post from './components/Post/Post';


function App() {
  const [data, setData] = useState([]); // State tanımlaması düzeltilmeli

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
      <Link to="user">User</Link>
      <Post />
     

    </div>
    <div>
    </div>
      <ul>
        {data.map((post) => (
          <div className='test' key={post.id}> { }
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
