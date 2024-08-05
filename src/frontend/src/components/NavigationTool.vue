<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">MyApp</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="/Home">Home</a>
        </li>
        <li>
          <router-link class="nav-link" to="/hello">Hello World</router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/about">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/contact">Contact</a>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'NavbarTool'
}
</script>

<style scoped>
/* Optional scoped styles */
.navbar {
  margin-bottom: 20px; /* Space below the navbar */
}
</style>
