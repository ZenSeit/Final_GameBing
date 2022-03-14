const express = require('express')
const router = express.Router()

const { loginCtrl, registerCtrl } = require('../controllers/auth')

/**
 * En este archivo se encuentran las rutas disponibles en el momento
 */

router.post('/login', loginCtrl)


router.post('/register', registerCtrl)


module.exports = router