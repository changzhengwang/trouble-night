import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import http from './http.js'
import globalMsg from './global.js'
import router from './router/index.js'
import store from './store'

Vue.prototype.$globalMsg = globalMsg;
Vue.config.productionTip = false;
Vue.use(ElementUI);
Vue.prototype.$axios = http;

//使用钩子函数对路由进行权限跳转
router.beforeEach((to, from, next) => {
    document.title = `${to.meta.title} | 宿舍管理平台`;
    const user = localStorage.getItem('user');
    if (!user && to.path !== '/login') {
        next('/login');
    } else {
        next();
    }
});

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
