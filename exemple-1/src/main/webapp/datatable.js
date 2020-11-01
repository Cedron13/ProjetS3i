


export const datatable = new class Datatable {


     get id() {
        return "team";
    }

    get configuration() {
        return {
            view: "datatable",
            id: this.id,
            hidden: false,
            tooltip: true,
            data: [],
            columns: [
                {
                    id: "PlaceNumber",
                    header: "id",
                    width: 75,
                    tooltip: "trimestre ID",
                    hidden: false,
                },
                {
                    id: "trimestre", header: "Trimestre",
                    hidden: false,
                    width: 200,
                    fillspace: true,
                },
                {
                    id: "debut",
                    header: "debut",
                    template: obj => {
                        return moment(obj.debut).format('D MMM');
                    },
                    width: 300,
                },
                {
                    id: "fin",
                    header: "fin",
                    template: obj => {
                        return moment(obj.fin).format('D MMM YYYY');
                    },
                    width: 300,
                },
            ],
        }
    }

    async loadTrimestre() {
        $$("main").showProgress({type: 'top'});
        return webix.ajax()
            .headers({"Content-Type": "application/json"})
            .get("api/trimestre")
            .then(data => data.json())
            .then(data => {
                $$(datatable.id).clearAll();
                $$(datatable.id).parse(data);
                $$("main").hideProgress();

            })
            .catch((reason) => {
                console.error(reason);
                webix.modalbox({
                    title: 'Voir des trimestres',
                    text: "Paramètres inconsistants pour accéder à la base de données de présence",
                    type: 'alert-error',
                });
            });
    }

}