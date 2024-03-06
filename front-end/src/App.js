import './App.css';
import { useEffect, useState } from 'react';
import Formulario from './Form.js';
import Tabela from './Tabela.js';

function App() {

  //Obj
  const contact = {
    id:0,
    firstname:"",
    lastname:"",
    phone:""
  }

  //Use State
  const [btnCadastrar, setBtnCadastrar] = useState(true);
  const [contacts, setContacts] = useState([]);
  const [objContact, setObjContacts] = useState(contact)

  //UseEffect
  useEffect(()=> {
    fetch("http://localhost:8080/list")

    .then(retorno => retorno.json())
    .then(retorno_convertido => setContacts(retorno_convertido));
  }, []);


  const aoDigitar = (e) => {
    setObjContacts({...objContact, [e.target.name]:e.target.value});
  }

  //Cadastrar 
  const Cadastrar = () => {
    fetch("http://localhost:8080/create",{
      method:'post',
      body:JSON.stringify(objContact),
      headers: {
        'Content-type':'Application/json',
        'Accept':'Application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      if (retorno_convertido.mensagem !== undefined) {
        alert(retorno_convertido.mensagem);
      } else {
        setContacts([...contacts, retorno_convertido])
        alert("Contato cadastrado com sucesso");
        limparFormulario();
      }
    })
  }

  //Alterar
  const Alterar = () => {
    fetch("http://localhost:8080/alter",{
      method:'put',
      body:JSON.stringify(objContact),
      headers: {
        'Content-type':'Application/json',
        'Accept':'Application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      if (retorno_convertido.mensagem !== undefined) {
        alert(retorno_convertido.mensagem);
      } else {
        alert("Contato alterado com sucesso");
        limparFormulario();
      }
    })
  }

  //Remover
  const Remover = () => {
    fetch("http://localhost:8080/remove?id="+objContact.id,{
      method:'delete',
      headers: {
        'Content-type':'Application/json',
        'Accept':'Application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
        alert(retorno_convertido.mensagem);
        limparFormulario();
    })
  }

  const limparFormulario = () => {
    setObjContacts(contact);
    setBtnCadastrar(true);
  }

  //Seleção
  const selecionarContato = (indice) => {
    setObjContacts(contacts[indice]);
    setBtnCadastrar(false);
  }

  return (
    <div class = 'content'>
      
      <Formulario botao={btnCadastrar} eventoTeclado={aoDigitar} cadastrar={Cadastrar} obj={objContact} cancelar={limparFormulario} remover={Remover} alterar={Alterar}/>
      <Tabela vetor={contacts} selecao={selecionarContato}/>
    </div>
  );
}

export default App;
