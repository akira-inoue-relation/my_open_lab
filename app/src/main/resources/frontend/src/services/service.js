import api from './api';

// API通信を管理する関数
const apiService = {
  getAccount(id) {
    return api.get(`/account/${id}`);
  },
  login(loginId, password) {
    return api.post('/auth/login', { loginId, password });
  },
};

export default apiService;
