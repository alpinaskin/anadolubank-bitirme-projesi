import { useEffect, useState } from 'react'
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';
import { Pie } from 'react-chartjs-2';
import BootstrapTable from 'react-bootstrap-table-next';
import './App.css';
import paginationFactory from 'react-bootstrap-table2-paginator';
import "react-bootstrap-table-next/dist/react-bootstrap-table2.min.css";


ChartJS.register(ArcElement, Tooltip, Legend);

function App() {
  const [policyTypes, setPolicyTypes] = useState([]);
  const [agencies, setAgencies] = useState([]);
  const [accounts, setAccounts] = useState([]);
  const [accountGenders, setAccountGenders] = useState([]);
  const [accountPolicies, setAccountPolicies] = useState([]);
  const [extendedPolicy, setExtendedPolicy] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/policy')
        .then(response => response.json())
        .then(data => setPolicyTypes(data))

    fetch('http://localhost:8080/agency')
        .then(response => response.json())
        .then(data => setAgencies(data))

    fetch('http://localhost:8080/account')
        .then(response => response.json())
        .then(data => {
          setAccounts(data)})

    fetch('http://localhost:8080/account/getGenders')
        .then(response => response.json())
        .then(data => setAccountGenders(data))

    fetch('http://localhost:8080/policy/extendedPolicy')
        .then(response => response.json)
        .then(data => setExtendedPolicy(data))
  },[]);
  
  const data = {
    labels: policyTypes.map(x => x.policyType),
    datasets: [
      {
        label: 'Policy Type Chart',
        data: policyTypes.map(x => x.number),
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)',
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)',
        ],
        borderWidth: 1,
      },
    ],
  };

  const genderData = {
    labels: accountGenders.map(x => x.gender),
    datasets: [
      {
        label: 'Genders Chart',
        data: accountGenders.map(x => x.number),
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)',
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)',
        ],
        borderWidth: 1,
      },
    ],
  };

  const policyColumn = [
    {dataField: 'firstName', text:'Adı'}, 
    {dataField: 'lastName', text:'Soyadı'}, 
    {dataField: 'agencyName', text:'Ajans Adı'},
    {dataField: 'startDate', text:'Başlangıç Tarihi'},
    {dataField: 'endDate', text:'Bitiş Tarihi'},
    {dataField: 'net', text:'Net'},
    {dataField: 'gross', text:'gross'},
    {dataField: 'comissionRate', text:'Komisyon Oranı'}
  ]
  const agencyColumn = [
    {
      dataField: 'id',
      text: 'ID'
    },
    {
      dataField: 'name',
      text: 'Ajans Adı'
    }
  ]
  const accountColumn = [
    {
      dataField: 'id',
      text: 'ID'
    },
    {
      dataField: 'firstName',
      text: 'Adı'
    },
    {
      dataField: 'lastName',
      text: 'Soyadı'
    },
    {
      dataField: 'birthday',
      text: 'Doğum Tarihi'
    }
  ]

  return (
    <div className="App">
      <div class="container">
        <div class="row">
          <h2 class="h2">
            Veriler
          </h2>
        </div>
        <div class="row">
          <div class="col-sm-8">
          <BootstrapTable bootstrap4 keyField='id' data={agencies} columns={agencyColumn} pagination={paginationFactory({ sizePerPage: 10 })}/>
          </div>
            
        </div>

        <div class="row">
        <BootstrapTable keyField='id' data={accounts} columns={accountColumn} pagination={paginationFactory({ sizePerPage: 10 })}/>
        </div>

        {accountPolicies?.length > 0 ?
         <div class="row">
            <div class="col-sm">
            <BootstrapTable keyField='id' data={extendedPolicy} columns={policyColumn} pagination={paginationFactory({ sizePerPage: 10 })}/>
            </div>
         </div>
         : <></>}
        <div class="row">
          <div class="col-sm">
              <Pie data={data}/>
            </div>
            <div class="col-sm">
              <Pie data={genderData}/>
            </div>
        </div>
      </div>
    </div>
  );
}

export default App;
