<template>
  <aside class="side-menu">
    <nav>
      <ul>
        <li>
          <router-link to="/accounts" class="menu-item">
            アカウント一覧
          </router-link>
        </li>
        <li>
          <router-link to="/accounts/register" class="menu-item">
            アカウント登録
          </router-link>
        </li>
      </ul>
    </nav>
  </aside>
</template>

<script>
export default {
  name: 'SideMenu'
}
</script>

<style scoped>
.side-menu {
  background-color: #f8f9fa;
  width: 250px;
  height: 100%;
  border-right: 1px solid #e9ecef;
  padding: 1.5rem 0;
}

.side-menu ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.side-menu li {
  margin-bottom: 0.5rem;
}

.menu-item {
  display: block;
  padding: 0.75rem 1.5rem;
  color: var(--text-dark);
  text-decoration: none;
  transition: background-color 0.3s;
}

.menu-item:hover,
.menu-item.router-link-active {
  background-color: var(--primary-color);
  color: white;
}
</style>
