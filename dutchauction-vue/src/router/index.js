import Vue from 'vue'
import Router from 'vue-router'
import CreateAuction from '../components/CreateAuction'
import HelloWorld from '../components/HelloWorld'
import AllAuctions from '../components/AllAuctions'
import ShowAuction from '../components/ShowAuction'

Vue.use(Router)

let router = new Router({
  routes: [
    {
      path: '/createAuction',
      name: 'Create Auction',
      component: CreateAuction,
      meta: { requiresAuth: false, requiresAdmin: false }
    },
    {
      path: '/',
      name: 'Hello World!',
      component: HelloWorld,
      meta: { requiresAuth: false, requiresAdmin: false }
    },
    {
      path: '/allAuctions',
      name: 'All Auctions',
      component: AllAuctions,
      meta: { requiresAuth: false, requiresAdmin: false }
    },
    {
      path: '/showAuction/:id',
      name: 'Auction Details',
      component: ShowAuction,
      meta: { requiresAuth: false, requiresAdmin: false }
    },
  ],
  mode: 'history'
}
)

export default router;
