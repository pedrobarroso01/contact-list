import './App.css';
import { useState } from 'react';
import Formulario from './Form.js';
import Tabela from './Tabela.js';

function App() {

  const [btnCadastrar, setBtnCadastrar] = useState(true);


  return (
    <div class = 'content'>
      <Formulario botao={btnCadastrar} />
      <Tabela/>
    </div>
  );
}

export default App;
