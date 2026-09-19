    }

    // Check if email is a string and contains "@"
    if (typeof email !== 'string' || !email.includes('@')) {
      return res.status(400).send('Invalid email format.');
    }

    // If all checks pass
    console.log('Received data:', { name, email, message });
    res.send('Data received successfully!');
  });

  app.listen(8080, () => {
    console.log('Server listening on port 8080');
  });
