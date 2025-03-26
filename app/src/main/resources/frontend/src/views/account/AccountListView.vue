<template>
  <div class="app-layout">
    <HeaderComponent />
    <div class="main-container">
      <SideMenu />
      <main class="content">
        <div class="content-header">
          <h2>アカウント一覧</h2>
          <router-link to="/accounts/register" class="btn btn-primary">新規登録</router-link>
        </div>
        
        <div class="card">
          <div class="table-responsive">
            <table class="table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>氏名</th>
                  <th>氏名（カナ）</th>
                  <th>店舗ID</th>
                  <th>ログインID</th>
                  <th>権限</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="account in accounts" :key="account.id">
                  <td>{{ account.id }}</td>
                  <td>{{ account.personName }}</td>
                  <td>{{ account.personNameKana }}</td>
                  <td>{{ account.storeId }}</td>
                  <td>{{ account.loginId }}</td>
                  <td>{{ account.authority }}</td>
                  <td>
                    <button class="btn btn-sm btn-secondary" @click="viewAccount(account.id)">詳細</button>
                  </td>
                </tr>
                <tr v-if="accounts.length === 0">
                  <td colspan="7" class="text-center">アカウントが登録されていません</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import HeaderComponent from '@/components/layout/Header.vue'
import SideMenu from '@/components/layout/SideMenu.vue'
import service from '../../services/service';

export default {
  name: 'AccountListView',
  components: {
    HeaderComponent,
    SideMenu
  },
  data() {
    return {
      accounts: [
        {
          id: 1,
          personName: '山田太郎',
          personNameKana: 'ヤマダタロウ',
          storeId: 1,
          loginId: 'yamada',
          authority: 1
        },
        {
          id: 2,
          personName: '佐藤花子',
          personNameKana: 'サトウハナコ',
          storeId: 2,
          loginId: 'satoh',
          authority: 2
        }
      ]
    }
  },
  methods: {
    async getAccount() {
      try {
        const response = await service.getAccount(1);
        console.log('response:', response);
      } catch (error) {
        console.log('エラー:', error);
      }
    },
  },
  mounted() {
    this.getAccount();
  },
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

.table {
  width: 100%;
  border-collapse: collapse;
}

.table th,
.table td {
  padding: 0.75rem;
  text-align: left;
  border-bottom: 1px solid var(--gray-medium);
}

.table th {
  font-weight: bold;
  background-color: var(--gray-medium);
}

.table-responsive {
  overflow-x: auto;
}

.btn-sm {
  padding: 0.25rem 0.5rem;
  font-size: 0.875rem;
}
</style>
