<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://upload.wikimedia.org/wikipedia/commons/2/29/VOC_gold.svg"
          transition="scale-transition"
          width="40"
        />
        <router-link style="text-decoration: none; color: inherit;" to="/">
          <div id="titleName" class="d-flex display-1">Dutch Auction</div>
        </router-link>
      </div>
      <div class="my-2 ml-3">
        <v-btn id="createAuction" class="mr-2" depressed small color="primary" to="/CreateAuction">Create Auction</v-btn>
        <v-btn id="showAuction" class="mr-2" depressed small color="primary" to="/AllAuctions">Show Auctions</v-btn>
      </div>
      <v-spacer></v-spacer>
      <v-btn depressed small color="primary" v-bind:disabled="isPlaying" @click="music" id="musicButton">Play Music</v-btn>
      <div class="ml-3">
        <v-switch v-model="$vuetify.theme.dark" hide-details label="Theme Dark"></v-switch>
      </div>
    </v-app-bar>
    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: "App",

  components: {},

  data: () => ({
    isPlaying: false
  }),
  methods: {
    music() {
      var audio = new Audio(require("./assets/theme.mp3")); // path to file
      audio.play();
      audio.volume = 0.02;
      this.isPlaying = true;
    }
  }
};
</script>
