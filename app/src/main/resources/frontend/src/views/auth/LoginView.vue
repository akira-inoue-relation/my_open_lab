<template>
  <div class="login-container">
    <div class="login-card">
      <div class="logo-container">
        <img src="../../assets/logo.png" alt="Yellow Fish Logo" class="logo" />
      </div>
      
      <form @submit.prevent="login" class="login-form">
        <div class="form-content">
          <div class="form-group">
            <label for="loginId">ログインID</label>
            <input 
              type="text" 
              id="loginId" 
              v-model="loginId" 
              required
            >
          </div>
          
          <div class="form-group">
            <label for="password">パスワード</label>
            <input 
              type="password" 
              id="password" 
              v-model="password" 
              required
            >
          </div>
          
          <div v-if="errorMessage" class="error-message">
            {{ errorMessage }}
          </div>
          
          <button type="submit" class="login-button" :disabled="isLoading">
            {{ isLoading ? 'ログイン中...' : 'ログイン' }}
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import service from '../../services/service';

export default {
  name: 'LoginView',
  data() {
    return {
      loginId: '',
      password: '',
      errorMessage: '',
      isLoading: false
    }
  },
  methods: {
    async login() {
      this.errorMessage = '';
      this.isLoading = true;
      
      try {
        await service.login(this.loginId, this.password);
        // ログイン成功
        this.$router.push('/accounts');
      } catch (error) {
        // ログイン失敗
        this.errorMessage = 'ログインIDまたはパスワードが正しくありません。';
        console.error('ログインエラー:', error);
      } finally {
        this.isLoading = false;
      }
    }
  }
}
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: linear-gradient(#195983,#e4e4e4);
}

.login-card {
  background-color: #ffeb3b; /* Yellow background */
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  padding: 2rem;
  width: 800px;
  height: 470px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.logo-container {
  display: flex;
  justify-content: center;
  margin-bottom: 2rem;
}

.logo {
  /* Height restriction removed as requested */
}

.login-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.form-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  margin-top: 2rem;
}

.form-group {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-bottom: 1.5rem;
  width: 100%;
  justify-content: center;
}

.form-group label {
  font-weight: bold;
  width: 100px;
  text-align: right;
  margin-right: 10px;
}

.form-group input {
  padding: 0.75rem;
  border: 2px solid #195983;
  border-radius: 10px;
  font-size: 1rem;
  width: 300px;
  box-sizing: border-box;
}

.error-message {
  color: #dc3545;
  font-size: 0.875rem;
  text-align: center;
}

.login-button {
  background-color: #1a5276; /* Blue button */
  color: white;
  border: none;
  border-radius: 10px;
  padding: 0.75rem;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s;
  margin-top: 1rem;
  width: 410px;
  margin-left: auto;
  margin-right: auto;
}

.login-button:hover {
  background-color: #154360;
}

.login-button:disabled {
  background-color: #7f8c8d;
  cursor: not-allowed;
}
</style>
