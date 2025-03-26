<template>
  <div class="app-layout">
    <HeaderComponent />
    <div class="main-container">
      <SideMenu />
      <main class="content">
        <div class="content-header">
          <h2>アカウント登録</h2>
          <router-link to="/accounts" class="btn btn-secondary">一覧に戻る</router-link>
        </div>
        
        <div class="card">
          <form @submit.prevent="registerAccount" class="account-form">
            <div class="form-group">
              <label for="personName">氏名</label>
              <input 
                type="text" 
                id="personName" 
                v-model="account.personName" 
                required
                placeholder="氏名を入力してください"
              >
            </div>
            
            <div class="form-group">
              <label for="personNameKana">氏名（カナ）</label>
              <input 
                type="text" 
                id="personNameKana" 
                v-model="account.personNameKana" 
                required
                placeholder="氏名（カナ）を入力してください"
              >
            </div>
            
            <div class="form-group">
              <label for="storeId">店舗ID</label>
              <input 
                type="number" 
                id="storeId" 
                v-model="account.storeId" 
                required
                placeholder="店舗IDを入力してください"
              >
            </div>
            
            <div class="form-group">
              <label for="loginId">ログインID</label>
              <input 
                type="text" 
                id="loginId" 
                v-model="account.loginId" 
                required
                placeholder="ログインIDを入力してください"
              >
            </div>
            
            <div class="form-group">
              <label for="password">パスワード</label>
              <input 
                type="password" 
                id="password" 
                v-model="account.password" 
                required
                placeholder="パスワードを入力してください"
              >
            </div>
            
            <div class="form-group">
              <label for="authority">権限</label>
              <select 
                id="authority" 
                v-model="account.authority" 
                required
              >
                <option value="">権限を選択してください</option>
                <option value="1">管理者</option>
                <option value="2">一般ユーザー</option>
              </select>
            </div>
            
            <div class="form-actions">
              <button type="submit" class="btn btn-primary">登録</button>
              <button type="button" class="btn btn-secondary" @click="resetForm">リセット</button>
            </div>
          </form>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import HeaderComponent from '@/components/layout/Header.vue'
import SideMenu from '@/components/layout/SideMenu.vue'

export default {
  name: 'AccountRegisterView',
  components: {
    HeaderComponent,
    SideMenu
  },
  data() {
    return {
      account: {
        personName: '',
        personNameKana: '',
        storeId: '',
        loginId: '',
        password: '',
        authority: ''
      }
    }
  },
  methods: {
    registerAccount() {
      // 実際のAPIを使用する場合はここでAPIを呼び出す
      console.log('アカウント登録:', this.account)
      
      // 登録成功後、一覧画面に遷移
      this.$router.push('/accounts')
    },
    resetForm() {
      this.account = {
        personName: '',
        personNameKana: '',
        storeId: '',
        loginId: '',
        password: '',
        authority: ''
      }
    }
  }
}
</script>

<style scoped>
.app-layout {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.main-container {
  display: flex;
  flex: 1;
}

.content {
  flex: 1;
  padding: 1.5rem;
  background-color: var(--gray-light);
}

.content-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1.5rem;
}

.card {
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  padding: 1.5rem;
}

.account-form {
  max-width: 600px;
  margin: 0 auto;
}

.form-actions {
  display: flex;
  gap: 1rem;
  margin-top: 2rem;
}
</style>
