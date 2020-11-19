
export const datatable = new class Datatable {

    get id(){
        return "lesPlaces";
    }

    get configuration() {
        return{
        view: "datatable",
        id:  this.id,
        hidden: false,
        tooltip: true,
        data: [],
        columns: [
        {
            id: "placenumber",
            header: "Numero de place",
            width: 300,
            tooltip: "Place Id",
            hidden: false,
        },
        {
            id: "etudiantname",
            header: "Nom des étudiants",
            hidden: false,
            width: 200,
            fillspace: true,
        },
        {
            id: "cip",
            header: "CIP",
            hidden: false,
            width: 300,
        },
    ]
}}
    async loadPlaces() {
        $$("main").showProgress({type: 'top'});
        return webix.ajax()
            .headers({"Content-Type": "application/json"})
            .get("api/local?localid=C1-5001&etudiants=bob;roger;rafael&disposition=1")
            .then(data => data.json())
            .then(data => {
                console.log(data);
                $$(datatable.id).clearAll();
                $$(datatable.id).parse(data);
                $$("main").hideProgress();

            })
           /* .catch((reason) => {
                console.error(reason);
                webix.modalbox({
                    title: 'Voir des trimestres',
                    text: "Paramètres inconsistants pour accéder à la base de données de présence",
                    type: 'alert-error',
                });
            }); */
    }

}