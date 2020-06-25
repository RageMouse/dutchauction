<template>
  <v-card class="mx-auto" max-width="1500">
    <v-container fluid>
      <v-row dense>
        <v-col v-for="card in cards" :key="card.auctionId" cols="12" md="3" sm="4" xs="12">
          <v-card>
            <v-img
              :src="'https://favorflav.com/images/shutterstock_758273548-916x458.jpg'"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="200px"
            >
              <v-card-title v-text="card.auctionName"></v-card-title>
            </v-img>

            <v-card-actions>
              <router-link :to="{path: '/showAuction/' + card.auctionId}" tag="v-btn">
                <v-btn text>Details</v-btn>
              </router-link>

              <v-spacer></v-spacer>

              <v-btn icon>
                <v-icon>mdi-heart</v-icon>
              </v-btn>

              <v-btn icon>
                <v-icon>mdi-bookmark</v-icon>
              </v-btn>

              <v-btn icon>
                <v-icon>mdi-share-variant</v-icon>
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
export default {
  name: "#app",
  mounted() {
    this.loadAuctions();
  },
  methods: {
      loadAuctions: function() {
        this.axios
          .get("http://192.168.99.100:8088/auction/")
          .then(response => (this.cards = response.data));
      }
    },
  data: () => ({
    cards: []
     })
};
</script>