<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <v-img
          src="https://upload.wikimedia.org/wikipedia/commons/2/29/VOC_gold.svg"
          class="my-3"
          contain
          height="200"
        />
      </v-col>

      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3">Welcome to Dutch Auction</h1>

        <p class="subheading font-weight-regular">
          For memes and games with other VOC advocates,
          <br />please join our online
          <a
            href="https://discord.gg/yuU4Q98"
            target="_blank"
          >Discord Community</a>
        </p>
      </v-col>

      <v-col class="mb-5" cols="12">
        <h2 class="headline font-weight-bold mb-3">What's next for Dutch Auction?</h2>

        <v-row justify="center">
          <a
            v-for="(next, i) in whatsNext"
            :key="i"
            :href="next.href"
            class="subheading mx-3"
            target="_blank"
          >{{ next.text }}</a>
        </v-row>
      </v-col>

      <v-col class="mb-5" cols="12">
        <h2 class="headline font-weight-bold mb-3">Important Links</h2>

        <v-row justify="center">
          <a
            v-for="(link, i) in importantLinks"
            :key="i"
            :href="link.href"
            class="subheading mx-3"
            target="_blank"
          >{{ link.text }}</a>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "HelloWorld",

  data: () => ({
    ecosystem: [
      {
        text: "vuetify-loader",
        href: "https://github.com/vuetifyjs/vuetify-loader"
      },
      {
        text: "github",
        href: "https://github.com/vuetifyjs/vuetify"
      },
      {
        text: "awesome-vuetify",
        href: "https://github.com/vuetifyjs/awesome-vuetify"
      }
    ],
    importantLinks: [
      {
        text: "Creator",
        href: "https://www.linkedin.com/in/dennis-sperber-45a829164"
      },
      {
        text: "News Feed",
        href: "https://www.reddit.com/r/cirkeltrek/"
      },
      {
        text: "National Anthem",
        href: "https://www.youtube.com/watch?v=b11-37Me_a4"
      },
      {
        text: "Best town in the country",
        href: "https://www.reddit.com/r/AarleRixtel/"
      }
    ],
    whatsNext: [
      {
        text: "Maybe add some of this",
        href: "https://vuetifyjs.com/en/components/cards/"
      },
      {
        text: "Maybe fix mobile scaling?",
        href: ""
      },
      {
        text: "Add more functionality",
        href: ""
      },
    ]
  }),
  methods: {
    
  }
};
</script>
