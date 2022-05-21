<template>
    <div id="app">
        <div v-for="(employee, key) in employees" v-bind:key="key">
            <div style="display: flex; flex-direction: row">
                <div
                    style="
                        display: flex;
                        flex-direction: column;
                        margin: 5%;
                        padding: 2%;
                        background-color: grey;
                    "
                >

                    <div class="textBox">
                        <h1>Employee:</h1>
                        <InputText
                            style="margin: 2%"
                            type="text"
                            v-model="employee.firstName"
                            placeholder="First Name"
                            v-on:change="isEdit = employee.id"
                        />
                        <InputText
                            style="margin: 2%"
                            type="text"
                            v-model="employee.lastName"
                            placeholder="Last Name"
                            v-on:change="isEdit = employee.id"
                        />
                    </div>
                    <div class="textBox">
                        <h1>Salary:</h1>
                        <InputText
                            style="margin: 1%"
                            type="text"
                            v-model="employee.salary"
                            placeholder="Salary"
                            v-on:change="isEdit = employee.id"
                        />
                    </div>
                    <div class="textBox">
                        <h1>Payed: {{ employee.cash }}</h1>
                    </div>
                    <Slider
                        v-model="employee.salary"
                        :max="999999"
                        v-on:change="isEdit = employee.id"
                        style="margin: 3%"
                    />
                    <Button
                        v-if="isEdit === employee.id"
                        style="margin: 3%"
                        label="Save"
                        class="p-button-success"
                        v-on:click="saveEmployee(employee)"
                    />

                </div>
            </div>
        </div>
        <Button style="v-on:click="addEmployee label="Add Employee" " />
        <Dialog :visible="errorMessage != null" closable="false">
            {{ errorMessage }}
            <Button
                label="close"
                icon="pi pi-times"
                class="p-button-text"
            />
        </Dialog>
    </div>
</template>

<script>
import InputText from "primevue/inputtext";
import Button from "primevue/button";
import Slider from "primevue/slider";
import Dialog from "primevue/dialog";
export default {
    name: "App",
    mounted() {
        const axios = require("axios");
        axios
            .get("http://localhost:8000/employee")
            .then((response) => (this.employees = response.data))
            .catch((error) => (this.errorMessage = error));
    },
    methods: {
       addEmployee() {
            const date = new Date().toISOString().split('T')[0];
            console.log(date)
            this.employees.push({
               id: Math.floor(Math.random() * 100000),
                    firstName: "",
                    lastName: "",
                    cash: 0,
                    salary: 0,
                });
            },


        saveEmployee(employee) {
            console.log(employee);
            const axios = require("axios");
            axios
                .post("http://localhost:8090/employee/add", {
                    id: employee.id,
                    lastName: employee.lastName,
                    firstName: employee.firstName,
                    salary: employee.salary,
                })
                .catch((error) => console.log(error));

            this.isEdit = null;
        },


    },

    data() {
        return {
            employees: [],
        };
    },

    сomponents: {
        InputText,
        Button,
        Slider,
        Dialog,
    },
};
</script>

<style>
#app {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
}

.textBox {
    display: flex;
    flex-direction: row;
    align-items: center;
    width: 65%;
    padding: auto;
}
</style>
