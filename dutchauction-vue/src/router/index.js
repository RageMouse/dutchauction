import Vue from 'vue'
import Router from 'vue-router'
import CreateAuction from '../components/CreateAuction'

Vue.use(Router)


let router = new Router({
  routes: [
    {
      path: '/createAuction',
      name: 'Create Auction',
      component: CreateAuction,
      meta: { requiresAuth: false, requiresAdmin: false }
    },
  ],
  mode: 'history'
}
)

export default router;
