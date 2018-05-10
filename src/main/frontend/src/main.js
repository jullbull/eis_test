// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueResource from 'vue-resource'




Vue.use(BootstrapVue);
Vue.use(VueResource);
Vue.config.productionTip = false;
Vue.http.options.root = 'http://localhost:4200/api/';

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App,
  },
  template: '<App/>'
});
