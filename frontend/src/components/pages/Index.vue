<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "사용자",
          link: "/users",
      },
      {
          text: "매장",
          link: "/stores",
      },
      {
          text: "권한",
          link: "/authorities",
      },
      {
          text: "매장이용기록",
          link: "/storeUsings",
      },
      {
          text: "권한변경기록",
          link: "/authorityChanings",
      },
      {
          text: "경고상황기록",
          link: "/warnings",
      },
    ],
  }),
};
</script>
