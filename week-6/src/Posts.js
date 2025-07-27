import React from 'react';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [
        {
          id: 1,
          title: "How React Simplifies Frontend Development",
          body: "React allows developers to build user interfaces efficiently using components, JSX, and virtual DOM."
        },
        {
          id: 2,
          title: "Top 5 Tips to Learn JavaScript Fast",
          body: "Focus on understanding functions, closures, array methods, async programming, and practicing through small projects."
        },
        {
          id: 3,
          title: "Understanding the Component Lifecycle in React",
          body: "Lifecycle methods like componentDidMount help in performing actions after the component renders to the DOM."
        }
      ],
      error: null
    };
  }

  componentDidCatch(error, info) {
    alert("An error occurred: " + error);
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h2>Blog Posts</h2>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ border: '1px solid gray', margin: '10px 0', padding: '10px', borderRadius: '5px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
