<template>
  <div>
    <div class="row">
      <div class="maxsize">
        <app-auto-complete class="maxsize" placeholder="Valiutos pavadinimas" :source="menu" resultsValue="code"
                           resultDisplay="name" v-model="values.code">


        </app-auto-complete>

      </div>
      <div class="maxsize">
        <app-date-picker format="yyyy-MM-dd"
                         placeholder="nuo" :disabledDates="disableDates" v-model="values.from"></app-date-picker>
      </div>
      <div class="maxsize">
        <app-date-picker format="yyyy-MM-dd"
                         placeholder="iki" :disabledDates="disableDates" v-model="values.to"></app-date-picker>
      </div>
      <button class="btn btn-dark" v-on:click="getCurrencyData">siusti</button>

<h1> valiuta pasikete: {{count}}
</h1>
    </div>
  </div>
</template>

<script>
  import AutoComplete from 'vuejs-auto-complete'
  import Datepicker from 'vuejs-datepicker';


  export default {
    name: "ViewContainer",

    props:{

      listOfCurrency:[],


    },

    data() {
      return {

        disableDates: {
          days: [0, 6]
        },

        values: {
          code: "",
          from: "",
          to: ""
        },
        count:"",
        today:"",
        newDateFrom: "",
        newDateTo: "",

        menu: [],
        currency: [],


      }
    },
    components: {

      appAutoComplete: AutoComplete,
      appDatePicker: Datepicker

    },
    methods: {


      getTodayDate(){

        let date = new Date();
        this.today = this.parseDate(date);
        console.log(this.today);

      },


      getMenuData() {
        this.$http.get("getall?date="+this.today).then(response => {
          return response.json();
        }).then(data => {
          const resultArray = [];
          for (let key in data) {
            resultArray.push(data[key]);

          }
          this.menu = resultArray;
          this.listOfCurrency = this.menu;
          this.$emit('listOfCurrency', this.listOfCurrency);
        //        this.$emit('page', this.page);
        });
      },
      getCurrencyData() {
        this.values.from = this.parseDate(this.values.from);
        this.values.to = this.parseDate(this.values.to);

        this.$http.get("from/to?code=" + this.values.code + "&from=" + this.values.from + "&to=" + this.values.to)
          .then(response => {
            return response.json();
          }).then(data => {
          const resultArray = [];
          for (let key in data) {
            resultArray.push(data[key]);

          }
          this.currency = resultArray;
          this.listOfCurrency = this.currency;
          this.$emit('listOfCurrency', this.listOfCurrency);



        });
        this.$http.get("getdifference?code=" + this.values.code + "&from=" + this.values.from +"&to=" + this.values.to).then(response => {
          return response.json();

        }).then(data =>{
          this.count = data;


        });


      },
      parseDate(value) {

        let date = new Date(value);

        let result = date.getFullYear() + "-" +
          ((date.getMonth() + 1) > 9 ? '' : '0') + (date.getMonth() + 1) + "-" +
          (date.getDate() > 9 ? '' : '0') + date.getDate();

        return result;


      },


    },
    created(){
      this.getTodayDate();
      this.getMenuData();

    },
    mounted() {


    },
    computed: {}


  }

</script>

<style scoped>
  .maxsize {

    max-width: 300px;
    height: 20px;
  }
</style>
