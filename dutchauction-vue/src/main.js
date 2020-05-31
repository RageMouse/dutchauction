import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import CreateAuction from "./components/CreateAuction.vue";
import router from './router/index'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  vuetify,
  router,
}).$mount('#app')

export default {
  name: 'App',
  components: {
    CreateAuction
  }
}