<template>
  <header class="header">
    <div class="container">
      <div class="header-content">
        <h1 class="logo">アカウント管理システム</h1>
        <div class="user-info" v-if="isLoggedIn">
          <span>ようこそ、ユーザー様</span>
          <button class="logout-btn" @click="logout">ログアウト</button>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: 'HeaderComponent',
  data() {
    return {
      isLoggedIn: true
    }
  },
  methods: {
    logout() {
      // ログアウト処理（実装は省略）
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>
.header {
  background-color: var(--primary-color);
  color: white;
  padding: 1rem 0;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.header-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  margin: 0;
  font-size: 1.5rem;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.logout-btn {
  background-color: transparent;
  border: 1px solid white;
  color: white;
  padding: 0.25rem 0.5rem;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.logout-btn:hover {
  background-color: rgba(255, 255, 255, 0.2);
}
</style>
