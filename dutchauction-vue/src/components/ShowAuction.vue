<template>
  <v-card class="mx-auto" max-width="1250">
    <v-img
      class="white--text align-end mt-4"
      height="500px"
      src="https://sy-rhapsody.nl/wp-content/uploads/2019/07/DSCN1569-2-Klein-768x432.jpg"
    >
      <v-card-title>4 Kratten Kokosnoten</v-card-title>
    </v-img>

    <v-card-subtitle class="pb-0">Number 10</v-card-subtitle>

    <v-card-text class="text--primary">
      <div>Sold by: Hendrick Simmons</div>

      <div>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</div>
    </v-card-text>

    <v-card-actions>
      <v-btn color="orange" @click="triggerSnackbar" text>Buy</v-btn>

      <v-btn color="orange" @click="triggerSnackbar" text>Bid</v-btn>

      <v-spacer></v-spacer>

      <v-btn color="orange" to="/AllAuctions" text>Back</v-btn>
    </v-card-actions>
    <v-snackbar v-model="snackbar">
      This feature is still WIP :)
      <v-btn color="pink" text @click="snackbar = false">Close</v-btn>
    </v-snackbar>
  </v-card>
</template>

<script>
export default {
 data: () => ({
    snackbar: false
  }),

  methods: {
    triggerSnackbar() {
      this.snackbar = true;
    },
  }
};
</script>