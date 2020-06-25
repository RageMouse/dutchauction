import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router/index'
import axios from 'axios'
import VueAxios from 'vue-axios'
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.config.productionTip = false

Vue.use(VueAxios, axios);
Vue.use(VueSweetalert2);

new Vue({
  render: h => h(App),
  vuetify,
  router,
  axios,
  VueAxios
}).$mount('#app')

export default {
  name: 'App',
  components: {
  }
}