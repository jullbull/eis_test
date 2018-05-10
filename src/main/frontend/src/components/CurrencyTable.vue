<template>
  <div>
    <table class="table-bordered  table ">
      <tr class="table-hover">
        <th>Valiutos Kodas</th>
        <th>Santykis</th>
        <th>Data</th>
        <th v-show="show">kaip pasikeite</th>
      </tr>
      <tr v-for="item in listOfCurrency">
        <td>
          {{item.code}}
        </td>
        <td>{{item.volume}}</td>
        <td>{{item.date = parseDate(item.date)}}</td>

      </tr>
    </table>


  </div>
</template>

<script>
  export default {

    name: "CurrencyTable",
    props: {
      listOfCurrency: [],
      show:""

    },
    data() {
      return {

        currency: [],
      }
    },
    methods:{
      parseDate(value) {

        let date = new Date(value);

        let result = date.getFullYear() + "-" +
          ((date.getMonth() + 1) > 9 ? '' : '0') + (date.getMonth() + 1) + "-" +
          (date.getDate() > 9 ? '' : '0') + date.getDate();

        return result;


      },

    }
  }
</script>

<style scoped>

</style>
