function responseForAllArticles() {
    fetch('http://localhost:8080/articles/all', {mode: 'no-cors'})
        .then(res => res.json())
        .then(data => console.log(data))
}