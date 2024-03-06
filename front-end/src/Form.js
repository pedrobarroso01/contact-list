function Formulario({botao, eventoTeclado, cadastrar, obj, cancelar, remover, alterar}) {
    return (
        <form>
            <input type="text" value={obj.firstname} onChange={eventoTeclado} name="firstname" placeholder="First name" className="form-control"/>
            <input type="text" value={obj.lastname} onChange={eventoTeclado} name="lastname" placeholder="Last name" className="form-control"/>
            <input type="tel" value={obj.phone} onChange={eventoTeclado} name="phone" placeholder="Phone" className="form-control" />

            {
                botao
                ?
                <input type="button" onClick={cadastrar} value="Create" className="btn btn-primary"/>
                :
                <div>
                    <input type="button" value="Alter" className="btn btn-warning" onClick={alterar}/>
                    <input type="button" value="Remove" className="btn btn-danger" onClick={remover}/>
                    <input type="button" value="Cancel" className="btn btn-secondary" onClick={cancelar}/>
                </div>
            }

        </form>
    )
}

export default Formulario;
