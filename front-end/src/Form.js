function Formulario({botao}) {
    return (
        <form>
            <input type="text" placeholder="First name" className="form-control"/>
            <input type="number" placeholder="Last name" className="form-control"/>
            <input type="number" placeholder="Phone" className="form-control" />

            {
                botao
                ?
                <input type="button" value="Cadastrar" className="btn btn-primary"/>
                :
                <div>
                    <input type="button" value="Alterar" className="btn btn-warning"/>
                    <input type="button" value="Excluir" className="btn btn-danger"/>
                    <input type="button" value="Cancelar" className="btn btn-secondary"/>
                </div>
            }

        </form>
    )
}

export default Formulario;
