const { verifyToken } = require('../helpers/generateToken')

/**
 * 
 * @param {*} req 
 * @param {*} res 
 * @param {*} next 
 * 
 * Con este metodo verificamos en el header del usuario que tenga un token valido para dar acceso a las diferentes rutas
 */

const checkAuth = async (req, res, next) => {
    try {
        const token = req.headers.authorization.split(' ').pop() 
        const tokenData = await verifyToken(token)
        if (tokenData._id) {
            next()
        } else {
            res.status(409)
            res.send({ error: 'Acceso no permitido!' })
        }

    } catch (e) {
        console.log(e)
        res.status(409)
        res.send({ error: 'Acceso no permitido!' })
    }

}

module.exports = checkAuth