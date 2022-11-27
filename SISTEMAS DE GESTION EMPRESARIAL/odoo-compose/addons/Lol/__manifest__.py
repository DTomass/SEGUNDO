# -*- coding: utf-8 -*-
{
	 'name': "lol",
    'summary': """league of legends""",
    'description': """
        Lol module to record matches score:
    """,
    'author': "Daniel",
    'website': "https://github.com/DTomass",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/master/openerp/addons/base/module/module_data.xml
    # for the full list
    'category': 'LOL',
    'version': '0.1',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    'data': [
        'views.xml',
	# 'vistas/matches.xml',
	# 'vistas/maps.xml',
	# 'vistas/characters.xml',
    ],
}