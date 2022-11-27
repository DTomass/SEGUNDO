from odoo import models, fields, api
from odoo.exceptions import ValidationError
import datetime



class Base(models.Model):
    _name = 'lol.base'
    _description = 'Base class to be inherited'

    name = fields.Char(string='Nombre', required=True)
    description = fields.Text(string='Descripción')

    _sql_constraints = [
        ('name_unique',
         'UNIQUE(name)',
         'El nombre debe ser único'),
    ]

class Luchador(models.Model):
    _name = 'lol.luchador'
    _description = 'Luchador de League of Legends'

    hp = fields.Integer(string='Puntos de vida')
    mp = fields.Integer(string='Puntos de maná')

class Campeon(models.Model):
    _name = 'lol.campeon'
    _description = 'Campeones de League of Legends'
    _inherits = {'lol.base': 'lol_base_id',
                 'lol.luchador': 'lol_luchador_id'}

    lol_base_id = fields.Many2one('lol.base', ondelete='cascade')
    lol_luchador_id = fields.Many2one('lol.luchador', ondelete='cascade')



    ataque = fields.Integer(string='Ataque')
    defensa = fields.Integer(string='Defensa')
    magia = fields.Integer(string='Magia')

class Mapa(models.Model):
    _name = 'lol.mapa'
    _description = 'Mapas de League of Legends'
    _inherit = 'lol.base'

    width = fields.Integer(string='Ancho')
    height = fields.Integer(string='Alto')


class heroes(models.Model):
    _name = 'lol.heroes' #la info se guarda en la tabla lol_heroes
    _inherit = 'lol.base'
    name = fields.Char()
    debilidades_id = fields.One2many(comodel_name='lol.debilidades', inverse_name='heroe_id', string="Debilidades")
    batalles_id = fields.One2many(comodel_name='lol.batallas', inverse_name='heroe_id', string="Batalles")
    edad = fields.Integer(string='Edad')
    altura = fields.Integer(string='Altura en cm')
    peso = fields.Integer(string='Peso')
    imc = fields.Integer(string='imc')
    anno_nacimiento = fields.Integer(string='Fecha de nacimiento', compute='_calc_nac_year')

    def _calc_nac_year(self):
        for record in self:
            record.anno_nacimiento = datetime.datetime.now().year - record.edad


    #validate eda > 18
    @api.constrains('edad')
    def _check_edad(self):
        for record in self:
            if record.edad < 18:
                raise ValidationError("La edad debe ser mayor de 18")

    #on change altura peso calcular imc
    @api.onchange('peso', 'altura')
    def _onchange_peso(self):
        if self.peso > 0 and self.altura > 0:
            self.imc = self.peso / ((self.altura/100) * (self.altura/100))


class villanos(models.Model):
    _name = 'lol.villanos' #la info se guarda en la tabla lol_villanos
    _rec_name = 'nombre'
    nombre = fields.Char()
    batallas_id = fields.One2many(comodel_name='lol.batallas', inverse_name='villano_id', string="Batallas")

class batallas(models.Model):
    _name = 'lol.batallas' #la info se guarda en la tabla lol_batallas

    name = fields.Char()
    heroe_id = fields.Many2one(comodel_name='lol.heroes', string="Heroe")
    villano_id = fields.Many2one(comodel_name='lol.villanos', string="Villano")
    fecha = fields.Date()
    lugar = fields.Char()

class debilidades(models.Model):
    _name = 'lol.debilidades'

    name = fields.Char()
    intensidad = fields.Integer()
    # add a selection field for skill level
    skill_level = fields.Selection([('easy', 'Easy'), ('medium', 'Medium'), ('hard', 'Hard')])
    heroe_id = fields.Many2one(comodel_name='lol.heroes', string="Heroe")