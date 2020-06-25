<template>
  <v-container>
    <v-card class="elevation-12">
      <v-toolbar dark color="primary">
        <v-toolbar-title>Create Auction</v-toolbar-title>
      </v-toolbar>
      <v-card-text>
        <v-form ref="form" v-model="valid" lazy-validation>
          <v-text-field
            id="auctionName"
            v-model="auctionName"
            :counter="25"
            :rules="nameRules"
            label="Name"
            required
          ></v-text-field>

          <v-textarea
            id="auctionDescription"
            v-model="auctionDescription"
            :counter="255"
            :rules="[v => !!v || 'Description is required']"
            label="Description"
            required
          ></v-textarea>
          <v-row>
            <v-col sm="6" cols="12">
              <v-date-picker
                v-model="endDate"
                :show-current="true"
                :landscape="true"
                :allowed-dates="allowedDates"
                :min="getNowDate"
                max="2022-01-01"
              ></v-date-picker>
            </v-col>
            <v-col>
              <v-img :src="require('../assets/200.gif')" class="my-3" contain height="273" />
            </v-col>
          </v-row>

          <v-btn
            id="validateButton"
            :disabled="!valid"
            color="success"
            class="mr-4"
            @click="validate"
          >Validate</v-btn>

          <v-btn id="resetFormButton" color="error" class="mr-4" @click="reset">Reset Form</v-btn>

          <v-btn
            id="resetValidationButton"
            color="warning"
            class="mr-4"
            @click="resetValidation"
          >Reset Validation</v-btn>
        </v-form>
      </v-card-text>
    </v-card>

    <v-snackbar v-model="snackbar">
      Success!
      <v-btn color="pink" text @click="snackbar = false">Close</v-btn>
    </v-snackbar>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    auctionDescription: "",
    endDate: "",
    valid: true,
    auctionName: "",
    nameRules: [
      v => !!v || "Name is required",
      v => (v && v.length <= 25) || "Name must be less than 25 characters"
    ],
    description: "",
    descriptionRules: [
      v => !!v || "Description is required",
      v => (v && v.length <= 255) || "Name must be less than 25 characters"
    ],
    selectedDate: null,
    snackbar: false
  }),

  methods: {
    validate() {
      if (this.$refs.form.validate()) {
        this.send();
      }
    },
    reset() {
      this.$refs.form.reset();
      this.selectedDate = null;
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    },
    send: function() {
      this.axios
        .post("http://192.168.99.100:8088/auction/", {
          auctionName: this.auctionName,
          auctionDescription: this.auctionDescription,
          endDate: this.endDate
        })
        .then(response => {
          console.log(response.status);
          if (response.status !== 204) {
            this.$swal("Alright!", "The auction is created!", "success");
          }
        })
        .catch(error => {
          console.log(error.response);
        });
    }
  },

  computed: {
    getNowDate() {
      var nowDate = new Date();
      nowDate.setDate(nowDate.getDate() + 7);
      return nowDate.toISOString().slice(0, 10);
    }
  }
};
</script>