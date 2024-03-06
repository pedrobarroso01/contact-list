function Formulario() {
    return (
        <form>
            <input type="text" placeholder="First name" className="form-control"/>
            <input type="number" placeholder="Last name" className="form-control"/>
            <input type="number" placeholder="Phone" className="form-control" />
            <input type="button" value="cadastrar" className="btn btn-primary"/>
            <input type="button" value="alterar" className="btn btn-warning"/>
            <input type="button" value="excluir" className="btn btn-danger"/>
            <input type="button" value="cancelar" className="btn btn-secondary"/>

        </form>
    )
}

export default Formulario;
